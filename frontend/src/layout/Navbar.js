import React from 'react';
import { Link } from 'react-router-dom';

export default function Navbar({ toggleTheme, theme }) {
    return (
        <div>
            <nav className="navbar navbar-dark bg-dark">
                <div className="container-fluid">
                    <a className="navbar-brand mb-0 h1 d-flex align-items-center">
                        <img src="/favicon.ico" alt="Ananasio" width="30" height="30" className="me-2" />
                        ananasio
                        </a>
                    <div className="btn-group" role="group" aria-label="Basic example">
                        <Link type="button" className="btn btn-outline-light" to="/">
                            Dishes
                        </Link>
                        <Link type="button" className="btn btn-outline-light" to="/ingredients">
                            Ingredients
                        </Link>
                    </div>
                    <div className="btn-group" role="group" aria-label="Basic example">
                        <Link className="btn btn-outline-light" to="/addDish">
                            Create dish
                        </Link>
                        <Link className="btn btn-outline-light" to="/addIngredient">
                            Create ingredient
                        </Link>
                    </div>

                    {/* Theme Toggle Button with consistent padding and margin */}
                    <button
                        className="btn btn-outline-light ms-2"
                        onClick={toggleTheme}
                        style={{
                            minWidth: '50px', // Set a fixed minimum width for the button
                        }}
                    >
                        {theme === 'light' ? '⏾' : '𖤓'}
                    </button>
                </div>
            </nav>
        </div>
    );
}
