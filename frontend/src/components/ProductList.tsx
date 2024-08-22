import { useEffect, useState } from 'react'
import axios from 'axios'
import { Product } from "../models/product.tsx"
import GetGroceriesById from "./GetGroceriesById.tsx"
import ProductCard from "./ProductCard.tsx"
import AddProduct from "./AddProduсt.tsx"



export default function ProductList() {
    const [products, setProducts] = useState<Product[]>([])

    const fetchProducts = () => {
        axios.get<Product[]>('/api/products')
            .then(response => {
                setProducts(response.data)
            })
            .catch(error => {
                console.error("Es gab einen Fehler beim Abrufen der Daten!", error);
            })
    }

    useEffect(() => {
        fetchProducts()
    }, [])

    function deleteThisItem(id: string) {
        axios.delete("/api/products/" + id)
            .then(() => fetchProducts())
            .catch(error => {
                console.error("Es ist ein Problem aufgetreten!", error)
            })
    }

    return (
        <div>
            <h2 className="sub-heading">Einkaufsliste</h2>
            <AddProduct productAdd={fetchProducts} />
            <GetGroceriesById products={products} />
            <div className="list-card">
                {products.map(product => (
                    <li key={product.id}>{product.name} - Menge: {product.amount}
                        <ProductCard key={product.id} product={product}/>
                        <button onClick={() => deleteThisItem(product.id)}> Produkt löschen</button>
                    </li>
                ))}
            </div>
        </div>
    );
}

