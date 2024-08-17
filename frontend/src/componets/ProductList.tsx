import { useEffect, useState } from 'react';
import axios from 'axios';
import { Product } from '../models/product.tsx';

export default function ProductList() {
    const [products, setProducts] = useState<Product[]>([]); // Verwende den Typ für die State-Variable

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
        <div>
            <h1>Einkaufsliste</h1>
            <ul>
                {products.map(product => (
                    <li key={product.id}>{product.name} - Menge: {product.amount}</li>
                ))}
            </ul>
        </div>
    );
}


