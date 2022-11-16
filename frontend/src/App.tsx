import Header from "./components/Header";
import SalesCard from "./components/SalesCard";

function App() {
  return (
    //é necessário colocar as tags entre <></> (fragment) porque o React exige assim.
    <>
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
