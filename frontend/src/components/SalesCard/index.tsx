import NotificationButton from '../NotificationButton';
import './styles.css';
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import { useState } from 'react';

function SalesCard() {

    const max = new Date();
    /*- no segundo new Date() estamos criando o objeto
    - o método setDate altera a data do objeto criado, passando a data atual new Date() pelo método .getDate() 
    menos a quantidade que dias que quiser*/
    const min = new Date(new Date().setDate(new Date().getDate() - 365));


    /*- minDate variável que guarda o dado, setMinDate método que altera o dado, useState método que guarda o estado 
   do componente
   - new Date() pega a data atual
   - uando declaramos dados compostos colocamos entre []*/
    const [minDate, setMinDate] = useState(min);
    const [maxDate, setMaxDate] = useState(max);



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
                            <tr>
                                <td className="show992">#341</td>
                                <td className="show576">08/07/2022</td>
                                <td>Anakin</td>
                                <td className="show992">15</td>
                                <td className="show992">11</td>
                                <td>R$ 55300.00</td>
                                <td>
                                    <div className="dsmeta-blue-btn-container">
                                        <NotificationButton />
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td className="show992">#341</td>
                                <td className="show576">08/07/2022</td>
                                <td>Anakin</td>
                                <td className="show992">15</td>
                                <td className="show992">11</td>
                                <td>R$ 55300.00</td>
                                <td>
                                    <div className="dsmeta-blue-btn-container">
                                        <NotificationButton />
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td className="show992">#341</td>
                                <td className="show576">08/07/2022</td>
                                <td>Anakin</td>
                                <td className="show992">15</td>
                                <td className="show992">11</td>
                                <td>R$ 55300.00</td>
                                <td>
                                    <div className="dsmeta-blue-btn-container">
                                        <NotificationButton />
                                    </div>
                                </td>
                            </tr>
                        </tbody>

                    </table>
                </div>

            </div>
        </>



    )
}

export default SalesCard;