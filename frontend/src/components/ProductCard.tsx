import { Product } from "../models/product.tsx";
import axios from "axios";
import {useState} from "react";

type ProductCardProps = {
    product: Product;
    fetchData: () => void;
};

export default function ProductCard(props: Readonly<ProductCardProps>) {

    const [isInEditMode, setIsInEditmode] = useState(false);
    const [name, setName] = useState(props.product.name)
    const [amount, setAmount] = useState(props.product.amount)
    function deleteThisItem(id:string){
        axios.delete("/api/products/" + id)
            .then(() => props.fetchData())

                .catch(error => {
                    console.error("Es gab einen Fehler beim Abrufen der Daten!", error);
                })

    }
    function updateThisItem(id:string){
        axios.put("/api/products/" + id)

    }

    function toggleEditModus() {
        setIsInEditmode(!isInEditMode)
    }

    const newProduct={
        name:name.trim(), amount:parseInt(amount)
    }

    return (
        <div className="product-card">
            <div className="product-card-info">
                {isInEditMode ? <input type="text" value={name} onChange={(event)=>setName(event.target.value)}/> : <h3>{props.product.name}</h3>}
                {isInEditMode ? <input type="number" value={amount} onChange={(event)=>setAmount(event.target.value)}/> : <h3>{props.product.amount}</h3>}
                <p>Menge: {props.product.amount}</p>
            </div>
            <button onClick={() => deleteThisItem(props.product.id)}> Produkt löschen</button>
            <button>speichern in db</button>
            <button onClick={toggleEditModus}> bearbeiten</button>
        </div>
    );
}
