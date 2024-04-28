import React from "react";

const Footer = () => {
  return (
    <footer className="gradient-background bg-gray-800 text-white py-4">
      <div className="container mx-auto text-center">
        <p>
          &copy; {new Date().getFullYear()} Actualité de Tesla et de la ville de
          Boulogne-Billancourt.
        </p>
      </div>
    </footer>
  );
};

export default Footer;
