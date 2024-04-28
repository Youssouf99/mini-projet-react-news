import React from "react";
import TeslaNews from "../components/news/TeslaNews";
import Title from "../components/layouts/Title";

const Tesla = () => {
  return (
    <div className="mb-8">
      <Title title={"News Tesla"} />
      <TeslaNews />
    </div>
  );
};

export default Tesla;
