import React from "react";

const Article = ({ title, author, description, urlToImage }) => {
  return (
    <>
      {" "}
      {author !== "null" && (
        <div className="bg-white shadow-md rounded p-4 m-4">
          <div className="flex">
            {urlToImage !== "null" && (
              <img
                src={urlToImage}
                alt="Article"
                className="w-24 h-24 mr-4 object-cover rounded"
              />
            )}
            <div>
              <h2 className="text-xl font-bold">{title}</h2>
              <p className="text-gray-600">{author}</p>
              <p className="mt-2">{description}</p>
            </div>
          </div>
        </div>
      )}
    </>
  );
};

export default Article;
