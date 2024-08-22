import { useState, ChangeEvent, FormEvent } from 'react'
import axios from 'axios'
import { Product } from "../models/product.tsx"


type AddProductProps = {
    productAdd: () => void;
};

export default function AddProduct({ productAdd }: AddProductProps) {
    const [name, setName] = useState("");
    const [amount, setAmount] = useState("")

    const handleSubmit = (event: FormEvent<HTMLFormElement>) => {
        event.preventDefault();

        const newProduct = {
            name: name.trim(),
            amount: parseInt(amount)
        }

        axios.post<Product>("/api/products", newProduct)
            .then(() => {
                setName("")
                setAmount("")
                productAdd()
            })
            .catch(error => {
                console.error("Es ist ein Fehler aufgetreten!", error)
            })
    }

    return (
        <div className="add-product">
            <h3>Neues Produkt hinzufügen</h3>
            <form onSubmit={handleSubmit}>
                <input type="text" value={name} onChange={(event: ChangeEvent<HTMLInputElement>) => setName(event.target.value)}
                    placeholder="Product name" />
                <input type="number" value={amount}
                    onChange={(event: ChangeEvent<HTMLInputElement>) => setAmount(event.target.value)}
                    placeholder="Menge"/>
                <button type="submit">Produkt hinzufügen </button>
            </form>
        </div>
    )
}
