import { Option, Select } from "@material-tailwind/react";
import React from "react";

const SortSelector = ({ sortOrder, onSortOrderChange }) => {
  const handleSortOrderChange = (event) => {
    onSortOrderChange(event);
  };

  return (
    <div className="w-72 flex items-center mb-4">
      <Select
        onChange={handleSortOrderChange}
        label="Filtrer par date"
        className="bg-gray-100"
        value={sortOrder}
      >
        <Option value="desc">Décroissant</Option>
        <Option value="asc">Croissant</Option>
      </Select>
    </div>
  );
};

export default SortSelector;
