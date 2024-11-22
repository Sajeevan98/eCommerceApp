import { useEffect, useState } from 'react'
import './App.css'
import ProductList from './components/productList';
import CategoryFilter from './components/CategoryFilter';

function App() {

  const [product, setProduct] = useState([]);
  const [category, setCategory] = useState([]);
  const [selectCategory, setSelectedCategory] = useState(null);
  const [search, setSearch] = useState("");
  const [sort, setSort] = useState("asc");
  
  
  useEffect(()=>{
    fetch('http://localhost:8081/api/products')
      .then(respose => respose.json())
      .then(data => setProduct(data));

      fetch('http://localhost:8081/api/categories')
      .then(respose => respose.json())
      .then(data => setCategory(data));

  }, [])

  const handleSearchChange = (event) =>{
      setSearch(event.target.value);
  }
  const handleSortChange = (event) =>{
    setSort(event.target.value);
  }

  const handleCategorySelect = (categoryId) =>{
    setSelectedCategory(categoryId ? Number(categoryId) : null );
  }

  const filterProduct = product.filter(
          pro=>{
            return (
              (selectCategory ? pro.category.id === selectCategory : true)
              &&
              pro.name.toLowerCase().includes(search.toLowerCase())
            )
          }
  ).sort(
    (a, b)=>{
      if(sort ==="asc")
        return a.price - b.price;
      else
        return b.price - a.price;
    }
  )

  return (
    <>
      <div className='container mx-auto'>
        <h2 className='my-4 text-primary text-center'>Product Catalog</h2>
        <div className='row align-items-center mb-4'>
          <div className='col-md-3 col-sm-12 mb-4'>
            <CategoryFilter category={category} onSelect={handleCategorySelect}/>

          </div>
          <div className='col-md-5 col-sm-12 mb-4'>
            <input type='text' className='form-control' placeholder='search for products' onChange={handleSearchChange}/>

          </div>
          <div className='col-md-4 col-sm-12 mb-4'>
            <select className='form-control' onChange={handleSortChange}>
              <option value="asc">Sort by Price: Low to High</option>
              <option value="desc">Sort by Price: High to Low</option>
            </select>
          </div>
        </div>
        <div>
          {
            filterProduct.length ? (
              <ProductList product={filterProduct}/>
            ) : (
              <h5>No Product Found.</h5>
            )
          }
        </div>
      </div>
    </>
  )
}

export default App
