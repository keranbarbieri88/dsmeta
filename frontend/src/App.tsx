import Header from "./components/Header";
import SalesCard from "./components/SalesCard";

/*Biblioteca React que permite adicionar notificações do sistema ao seu aplicativo com facilidade 
e também pode ser usada para definir notificações e alertas*/
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

function App() {
  return (
    //é necessário colocar as tags entre <></> (fragment) porque o React exige assim.
    <>
      <ToastContainer />
      <Header />
      <main>
        <section id="sales">
          <div className="dsmeta-container">
            <SalesCard />
          </div>
        </section>
      </main>
    </>
  )
}

export default App;
