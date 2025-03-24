import './App.css';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import Navbar from './layout/Navbar';
import Home from './pages/Home';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import AddDish from './dishes/AddDish';
import EditDish from './dishes/EditDish';
import ViewDish from './dishes/ViewDish';
import ListOfIngredients from './ingredients/ListOfIngredients';
import AddIngredient from './ingredients/AddIngredient';
import EditIngredient from './ingredients/EditIngredient';
import ViewIngredient from './ingredients/ViewIngredient';
import AddIngredientToTheDish from './ingredients/AddIngredientToTheDish';
import { useState, useEffect } from 'react';

function App() {
  // Manage the theme state
  const [theme, setTheme] = useState(localStorage.getItem("theme") || "light");

  useEffect(() => {
    document.documentElement.setAttribute('data-theme', theme);
    localStorage.setItem('theme', theme); // Store theme in localStorage
  }, [theme]);

  const toggleTheme = () => {
    setTheme((prevTheme) => (prevTheme === "light" ? "dark" : "light"));
  };

  return (
    <div className="App">
      <Router>
        <Navbar toggleTheme={toggleTheme} theme={theme} />
        <Routes>
          <Route exact path="/" element={<Home />} />
          <Route exact path="/addDish" element={<AddDish />} />
          <Route exact path="/updateDish/:id" element={<EditDish />} />
          <Route exact path="/dishDescription/:id" element={<ViewDish />} />
          <Route exact path="/ingredients" element={<ListOfIngredients />} />
          <Route exact path="/addIngredient" element={<AddIngredient />} />
          <Route exact path="/updateIngredient/:id" element={<EditIngredient />} />
          <Route exact path="/ingredientDescription/:id" element={<ViewIngredient />} />
          <Route exact path="/addIngredietntToDish/:id" element={<AddIngredientToTheDish />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
