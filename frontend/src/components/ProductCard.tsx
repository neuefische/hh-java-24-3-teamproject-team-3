import { Product } from "../models/product.tsx";

type ProductCardProps = {
    product: Product;
};

export default function ProductCard(props: Readonly<ProductCardProps>) {
    return (
        <div className="product-card">
            <div className="product-card-info">
                <h3>{props.product.name}</h3>
                <p>Menge: {props.product.amount}</p>
            </div>
        </div>
    );
}
