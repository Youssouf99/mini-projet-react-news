import { ArrowLeftIcon, ArrowRightIcon } from "@heroicons/react/16/solid";
import { Button, IconButton } from "@material-tailwind/react";
import React, { useEffect, useState } from "react";

const DefaultPagination = ({ totalPages, currentPage, setCurrentPage }) => {
  const [active, setActive] = useState(currentPage);

  useEffect(() => {
    setCurrentPage(active);
  }, [active]);

  const next = () => {
    if (active === totalPages) return;
    setActive(active + 1);
    //    setCurrentPage(active + 1);
  };

  const prev = () => {
    if (active === 1) return;

    setActive(active - 1);
  };

  const renderPageButtons = () => {
    const buttons = [];
    for (let i = 1; i <= totalPages; i++) {
      buttons.push(
        <IconButton
          key={i}
          onClick={() => setActive(i)}
          variant={active === i ? "filled" : "text"}
          color="gray"
        >
          {i}
        </IconButton>
      );
    }
    return buttons;
  };

  return (
    <div className="flex flex-col sm:flex-row items-center justify-center gap-4">
      <Button
        variant="text"
        className="flex items-center gap-2"
        onClick={prev}
        disabled={active === 1}
      >
        <ArrowLeftIcon strokeWidth={2} className="h-4 w-4" /> Previous
      </Button>
      <div className="flex flex-wrap justify-center gap-2">
        {renderPageButtons()}
      </div>
      <Button
        variant="text"
        className="flex items-center gap-2"
        onClick={next}
        disabled={active === totalPages}
      >
        Next <ArrowRightIcon strokeWidth={2} className="h-4 w-4" />
      </Button>
    </div>
  );
};

export default DefaultPagination;
