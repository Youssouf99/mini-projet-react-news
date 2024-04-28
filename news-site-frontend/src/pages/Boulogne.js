import React from "react";
import BoulogneNews from "../components/news/BoulogneNews";
import Title from "../components/layouts/Title";

const Boulogne = () => {
  return (
    <div className="mb-8">
      <Title title={"Actualité de la ville de Boulogne-Billancourt"} />
      <BoulogneNews />
    </div>
  );
};

export default Boulogne;
