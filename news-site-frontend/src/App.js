import "./App.css";
import News from "./components/News";

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <div className="p-5 max-w-md mx-auto bg-white rounded-xl shadow-md flex items-center space-x-4">
          <div>
            <div className="text-xl font-medium text-black">
              News Site Project
            </div>
            <p className="text-gray-500">
              Get the latest news updates right here.
            </p>
          </div>
        </div>
      </header>
      <News />
    </div>
  );
}

export default App;
