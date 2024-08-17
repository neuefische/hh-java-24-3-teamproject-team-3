import { useEffect, useState } from 'react';
import axios from 'axios';
import './App.css';
import GetGroceriesById from "./componets/GetGroceriesById";
import {Product} from "./models/product.tsx";

function App() {
    const [products, setProducts] = useState<Product[]>([]);

    useEffect(() => {
        axios.get<Product[]>('api/products')
            .then(response => {
                setProducts(response.data);
            })
            .catch(error => {
                console.error("Es gab einen Fehler beim Abrufen der Daten!", error);
            });
    }, []);

    return (
        <>
            <h1>Groceries app</h1>
            <GetGroceriesById products={products} />

        </>
    );
}

export default App;
