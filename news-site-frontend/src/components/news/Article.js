import {
  Button,
  Card,
  CardBody,
  CardFooter,
  CardHeader,
  Typography,
} from "@material-tailwind/react";
import React from "react";

const Article = ({ title, author, description, urlToImage }) => {
  return (
    <Card className="mt-6 bg-gray-200">
      <CardHeader color="blue-gray" className="relative h-56">
        {urlToImage !== "null" && <img src={urlToImage} alt="Article" />}
      </CardHeader>
      <CardBody>
        <Typography variant="h5" color="blue-gray" className="mb-2">
          {title}
        </Typography>
        <Typography>{description}</Typography>
      </CardBody>
      <CardFooter className="pt-0">
        <Typography className="font-normal">{author}</Typography>
      </CardFooter>
    </Card>
  );
};

export default Article;
