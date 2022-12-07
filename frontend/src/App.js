import { BrowserRouter, Routes, Route } from "react-router-dom";
import "./App.css";
import Footer from "./components/Footer";
import Header from "./components/Header";
import ArticleList from "./components/ArticleList";
import ArticleCreate from "./components/ArticleCreate";

function App() {
  return (
    <BrowserRouter>
      <Header />
      <Routes>
        <Route path="/" element={<ArticleList />} />
        <Route path="/create-article" element={<ArticleCreate />} />
      </Routes>
      <Footer />
    </BrowserRouter>
  );
}

export default App;
