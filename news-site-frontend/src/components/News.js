import React, { useEffect, useState } from "react";
import Article from "./Article";
import axios from "axios";

const News = () => {
  const [news, setNews] = useState([]);

  useEffect(() => {
    fetchNews();
  }, []);

  const fetchNews = async () => {
    try {
      const response = await axios.get("http://localhost:8080/api/news");
      setNews(response.data);
    } catch (error) {
      console.error("Error fetching news:", error);
    }
  };

  return (
    <div className="container mx-auto">
      <h1 className="text-3xl font-bold text-center mt-8">
        Dernières actualités
      </h1>
      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4 mt-8">
        {news.map((article, index) => (
          <Article key={index} {...article} />
        ))}
      </div>
    </div>
  );
};

export default News;
