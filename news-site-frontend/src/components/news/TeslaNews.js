import React, { useEffect, useMemo, useState } from "react";
import Article from "./Article";
import axios from "axios";
import SourceSelector from "../selectors/SourceSelector";
import SortSelector from "../selectors/SortSelector";
import { Alert, Spinner } from "@material-tailwind/react";

const TeslaNews = () => {
  const [news, setNews] = useState([]);
  const [selectedSource, setSelectedSource] = useState("");
  const [sortOrder, setSortOrder] = useState("desc");
  const [isLoading, setIsLoading] = useState(false);
  const [error, setError] = useState(null);

  useEffect(() => {
    fetchNews();
  }, [selectedSource, sortOrder]);

  const fetchNews = async () => {
    setIsLoading(true);
    setError(null);
    try {
      let url = `http://localhost:8080/api/news/articles?sort=${sortOrder}`;
      if (selectedSource) {
        url += `&source=${selectedSource}`;
      }
      const response = await axios.get(url);
      setNews(response.data);
    } catch (error) {
      console.error("Error fetching news:", error);
      setError("Erreur lors du chargement des articles.");
    } finally {
      setIsLoading(false);
    }
  };

  // Utiliser useMemo pour mettre en cache le résultat de fetchNews
  const cacheNews = useMemo(() => {
    return news;
  }, [news]);

  const handleSourceSelect = (source) => {
    setSelectedSource(source);
  };

  const handleSortOrderChange = (newSortOrder) => {
    setSortOrder(newSortOrder);
  };

  // Déterminer le nombre de colonnes en fonction du nombre d'articles
  let gridColumns;
  if (cacheNews.length === 1) {
    gridColumns = "grid-cols-1 sm:grid-cols-1 lg:grid-cols-1";
  } else if (cacheNews.length === 2) {
    gridColumns = "grid-cols-1 sm:grid-cols-2 lg:grid-cols-1";
  } else {
    gridColumns = "grid-cols-1 sm:grid-cols-2 lg:grid-cols-3";
  }

  return (
    <div className="container mx-auto">
      <div className="flex flex-col md:flex-row justify-center items-center mt-4">
        <SourceSelector onSelect={handleSourceSelect} />
        <div className="md:ml-4 mt-4 md:mt-0">
          <SortSelector
            sortOrder={sortOrder}
            onSortOrderChange={handleSortOrderChange}
          />
        </div>
      </div>

      {isLoading ? (
        <div className="flex justify-center items-center mt-8">
          <Spinner className="h-16 w-16" color="green" />
        </div>
      ) : error ? (
        <div className="flex justify-center items-center mt-8">
          <Alert color="red">{error}</Alert>
        </div>
      ) : cacheNews.length > 0 ? (
        <div className={`grid gap-4 mt-8 ${gridColumns}`}>
          {cacheNews.map((article, index) => (
            <Article key={index} {...article} />
          ))}
        </div>
      ) : (
        <div className="text-center mt-8 text-gray-500">
          {" "}
          {/* Ajouter une marge supplémentaire pour les grands écrans */}
          Aucun article trouvé.
        </div>
      )}
    </div>
  );
};

export default TeslaNews;
