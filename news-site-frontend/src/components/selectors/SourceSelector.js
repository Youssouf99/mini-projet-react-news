import React, { useEffect, useState } from "react";
import axios from "axios";
import { Alert, Option, Select, Spinner } from "@material-tailwind/react";

const SourceSelector = ({ onSelect }) => {
  const [sources, setSources] = useState([]);
  const [isLoading, setIsLoading] = useState(false);
  const [error, setError] = useState(null);
  const [selectedValue, setSelectedValue] = useState("Toutes les sources");

  useEffect(() => {
    fetchSources();
  }, []);

  const fetchSources = async () => {
    setIsLoading(true);
    setError(null);
    try {
      const response = await axios.get(
        "http://localhost:8080/api/news/sources"
      );
      // Tri des sources par ordre alphabétique du nom
      const sortedSources = response.data.sort((a, b) =>
        a.name.localeCompare(b.name)
      );
      setSources([{ name: "Toutes les sources" }, ...sortedSources]);
    } catch (error) {
      console.error("Error fetching sources:", error);
      setError("Erreur lors du chargement des sources.");
    } finally {
      setIsLoading(false);
    }
  };

  const handleSelectChange = (element) => {
    // const selectedSource = event.target.value;

    element === "Toutes les sources" ? onSelect("") : onSelect(element);
    // onSelect(event);

    // onSelect(event);
  };

  return (
    <div className="w-60 flex items-center mb-4">
      {isLoading ? (
        <div className="flex justify-center items-center m-20 ">
          <Spinner className="h-16 w-16" color="green" />
        </div>
      ) : error ? (
        <div className="flex justify-center items-center m-20 ">
          <Alert color="red">{error}</Alert>
        </div>
      ) : (
        <Select
          onChange={handleSelectChange}
          label="Filtrer par source "
          className="bg-gray-100"
          value={selectedValue}
        >
          {sources.map((source, index) => (
            <Option key={index} value={source.name}>
              {source?.name}
            </Option>
          ))}
        </Select>
      )}
    </div>
  );
};

export default SourceSelector;
