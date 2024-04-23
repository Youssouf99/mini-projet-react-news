import React from "react";

const Article = ({ title, author, description }) => {
  return (
    <div className="bg-white shadow-md rounded p-4 m-4">
      <h2 className="text-xl font-bold">{title}</h2>
      <p className="text-gray-600">{author}</p>
      <p className="mt-2">{description}</p>
    </div>
  );
};

export default Article;
