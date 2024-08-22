
import axios from 'axios';
import { Product } from '../models/product.tsx';
import GetGroceriesById from "./GetGroceriesById.tsx";
import ProductCard from "./ProductCard.tsx";
import {useEffect, useState} from "react";

export default function ProductList() {
    const [products, setProducts] = useState<Product[]>([]);



    function fetchData() {
        axios.get<Product[]>('/api/products')
            .then(response => {
                setProducts(response.data);
            })
            .catch(error => {
                console.error("Es gab einen Fehler beim Abrufen der Daten!", error);
            });
    }

    useEffect(() => {
        fetchData()
    }, []);



    return (
        <div>
            <h2 className="sub-heading">Einkaufsliste</h2>
            <GetGroceriesById products={products}/>
            <div className="list-card">
                {products.map(product => (
                    <li key={product.id}>{product.name} - Menge: {product.amount}
                        <ProductCard key={product.id} product={product} fetchData={fetchData} initialFetchData={fetchData}/>

                    </li>
                ))}
            </div>

        </div>
    );
}



