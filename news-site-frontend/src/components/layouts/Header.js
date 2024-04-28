import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import "./Header.css";
import { Button, Tab, Tabs, TabsHeader } from "@material-tailwind/react";

const Header = () => {
  const [defaultPathName, setDefaultPathName] = useState(
    window.location.pathname === "/" ? "/tesla-news" : window.location.pathname
  );

  const isActive = (path) => {
    console.log("test 1", window.location.pathname);
    return window.location.pathname === "" ? "/tesla-news" : path;
  };

  return (
    <header className="h-20 gradient-background bg-gray-800 from-indigo-500 to-blue-600 text-white py-4 px-4 flex justify-between items-center">
      <div className="text-lg font-bold">
        <Link to="/" className="text-xl hover:text-gray-200">
          {/* <img src={logo} alt="Your Company Logo" className="h-8 mr-4" /> Adjust size and margin */}
        </Link>
      </div>
      <nav className="flex-grow flex gap-4 justify-center">
        <div className="flex w-max gap-4">
          <Tabs value={defaultPathName}>
            <TabsHeader>
              <Link to="/tesla-news" className="hover:text-gray-200">
                <Tab value={"/tesla-news"}>Tesla</Tab>
              </Link>
              <Link to="/boulogne-news" className="hover:text-gray-200">
                <Tab value={"/boulogne-news"}>Boulogne</Tab>
              </Link>
            </TabsHeader>
          </Tabs>
        </div>
      </nav>
    </header>
  );
};

export default Header;
