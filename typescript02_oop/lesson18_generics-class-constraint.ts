/**
 * Generics Class Constraints.
 * 
 * Class as constraint of generics.
 */

namespace genericsClassConstraints {
    
    interface IProduct {
        sell(): void;
    }

    class ProductA implements IProduct {
        sell(): void {
            console.log('Jual product A');
        }
    }

    class ProductB implements IProduct {
        sell(): void {
            console.log('Jual product B');
        }
    }

    const sellProducts = <T extends IProduct> (products: T[]): void => {
        products.forEach(item => item.sell());
    }

    const productA = new ProductA();
    const productB = new ProductB();
    sellProducts([productA, productB]);
}