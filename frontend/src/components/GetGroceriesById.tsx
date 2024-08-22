import {Product} from "../models/product.tsx";
import {ChangeEvent, FormEvent, useState} from "react";
import ProductCard from "./ProductCard.tsx";


type GetGroceriesByIdProps = {
    products: Product[],

}

export default function GetGroceriesById(props: Readonly<GetGroceriesByIdProps>){
    const [searchText, setSearchText] = useState("");
    const [submittedText, setSubmittedText]=useState("");

    const handleSubmit =(event: FormEvent<HTMLFormElement>)=>{
        event.preventDefault();
        setSubmittedText(searchText);
    }

    const filteredProducts : Product[] = submittedText ? props.products.filter((product:Product) => product.name.toLowerCase().includes(submittedText.toLowerCase())):[];

    const noProductsMessage = submittedText && filteredProducts.length === 0 ? (
        <p className="no-products-found">No products found</p>
    ) : null;

    return (
        <div className="search-card">
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    value={searchText}
                    onChange={(e: ChangeEvent<HTMLInputElement>) => setSearchText(e.target.value)}
                    placeholder="Search for a Product"
                />
                <button type="submit">Search</button>
            </form>
            {submittedText && filteredProducts.length > 0 ? (
                <div className="product-by-id">
                    <div>Found article(s):</div>
                    {filteredProducts.map(product => (
                        <ProductCard key={product.id} product={product} fetchData={()=>{}} initialFetchData={()=>{}}/>
                    ))}
                </div>
            ) : noProductsMessage}
        </div>
    );
}