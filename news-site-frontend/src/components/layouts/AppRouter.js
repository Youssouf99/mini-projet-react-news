import React from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Tesla from "../../pages/Tesla";
import Boulogne from "../../pages/Boulogne";
import Header from "./Header";
import Footer from "./Footer";
import NotFound from "../../pages/NotFound";

const AppRouter = () => {
  return (
    <BrowserRouter>
      <Header />
      <main>
        <Routes>
          <Route path="/" element={<Tesla />} />
          <Route path="/tesla-news" element={<Tesla />} />
          <Route path="/boulogne-news" element={<Boulogne />} />
          <Route path="/*" element={<NotFound />} />
        </Routes>
      </main>
      <Footer />
    </BrowserRouter>
  );
};

export default AppRouter;
