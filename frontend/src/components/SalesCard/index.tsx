import NotificationButton from '../NotificationButton';
import './styles.css';
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import { useEffect, useState } from 'react';
import axios from 'axios';
import { BASE_URL } from '../../utils/request';
import { Sale } from '../../models/sale';

function SalesCard() {

    const max = new Date();
    /*- no segundo new Date() estamos criando o objeto
    - o método setDate altera a data do objeto criado, passando a data atual new Date() pelo método .getDate() 
    menos a quantidade que dias que quiser*/
    const min = new Date(new Date().setDate(new Date().getDate() - 365));


    /*- minDate variável que guarda o dado, setMinDate método que altera o dado, useState método que guarda o estado 
   do componente
   - new Date() pega a data atual
   - quando declaramos dados compostos colocamos entre []*/
    const [minDate, setMinDate] = useState(min);
    const [maxDate, setMaxDate] = useState(max);

    /*useState com o tipo lista de Sale que armazenará a lista de vendas, com o nome do dado sales e o 
    nome da função que altera o dado, setSales*/
    const [sales, setSales] = useState<Sale[]>([]);

    /*react hook que utiliza como parametro uma função como primeiro argumento e uma lista como segundo argumento*/
    useEffect(() => {
        /*formata a data pegando apenas a fatia necessária*/
        const dmin = minDate.toISOString().slice(0, 10);
        const dmax = maxDate.toISOString().slice(0, 10);

        /*a função setSales será responsável por atualizar o useStates com o valor que retornou da API */
        axios.get(`${BASE_URL}/sales?minDate=${dmin}&maxDate=${dmax}`)
            .then(response => {
                setSales(response.data.content);
            });
    }, [minDate, maxDate]);


    return (
        <>
            <div className="dsmeta-card">
                <h2 className="dsmeta-sales-title">Vendas</h2>
                <div>
                    <div className="dsmeta-form-control-container">
                        {/*- quando fazemos comentários no HTML utilizando a biblioteca JavaScript
                        React precisamos colocar entra chaves
                         - onChange é o evento que identifica a alteração do estado dentro do componente 
                         - o setMinDate é o método que altera o estado
                          - date é o argumento da função*/}
                        <DatePicker
                            selected={minDate}
                            onChange={(date: Date) => setMinDate(date)}
                            className="dsmeta-form-control"
                            dateFormat="dd/MM/yyyy"
                        />
                    </div>
                    <div className="dsmeta-form-control-container">
                        <DatePicker
                            selected={maxDate}
                            onChange={(date: Date) => setMaxDate(date)}
                            className="dsmeta-form-control"
                            dateFormat="dd/MM/yyyy"
                        />
                    </div>
                </div>

                <div>
                    <table className="dsmeta-sales-table">
                        <thead>
                            <tr>
                                <th className="show992">ID</th>
                                <th className="show576">Data</th>
                                <th>Vendedor</th>
                                <th className="show992">Visitas</th>
                                <th className="show992">Vendas</th>
                                <th>Total</th>
                                <th>Notificar</th>
                            </tr>
                        </thead>
                        <tbody>
                            {sales.map(sale => {
                                return (
                                    <tr key={sale.id}>
                                        <td className="show992">{sale.id}</td>
                                        <td className="show576">{new Date(sale.date).toLocaleDateString()}</td>
                                        <td>{sale.sellerName}</td>
                                        <td className="show992">{sale.visited}</td>
                                        <td className="show992">{sale.deals}</td>
                                        <td>R$ {sale.amount.toFixed(2)}</td>
                                        <td>
                                            <div className="dsmeta-blue-btn-container">
                                                <NotificationButton saleId={sale.id} />
                                            </div>
                                        </td>
                                    </tr>
                                )
                            })
                            }
                        </tbody>

                    </table>
                </div>

            </div>
        </>



    )
}

export default SalesCard;