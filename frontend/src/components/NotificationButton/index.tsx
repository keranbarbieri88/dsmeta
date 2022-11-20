import axios from 'axios';
import { toast } from 'react-toastify';
import icon from '../../assets/img/notification-icon.svg';
import { BASE_URL } from '../../utils/request';
import './styles.css';


type Props = {
    saleId: number;  
}

/*função responsável pelo comportamento do botão, que no caso enviará a mensagem via SMS*/
function handleClick(id : number){
    axios(`${BASE_URL}/sales/${id}/notification`)
       .then(response => {
           toast.info("SMS enviado com sucesso!")
       })       
}

function NotificationButton({saleId}: Props) {
    return (
        <div className="dsmeta-blue-btn" onClick={() => handleClick(saleId)}>
            <img src={icon} alt="Notificar" />
        </div>

    )
}

export default NotificationButton;
