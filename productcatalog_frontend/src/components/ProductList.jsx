import React from 'react'

const ProductList = ({product}) => {
  return (
    <div className='row'>
        {
            product.map(item=>(
                <div className='col-lg-4 col-md-6 col-sm-12 mb-4' key={item.id}>
                    <div className='card h-100'>
                        <img src={item.imageUrl || 'https://placehold.co/600x400'} className='card-img-top' alt={item.name} />
                        <div className="card-body" >
                            <h5 className="card-title text-center">{item.name}</h5>
                            <p className="card-text font-monospace text-center">{item.description}</p>
                            <p className="card-text text-danger text-center"><strong>LKR.{item.price}</strong></p>
                        </div>
                    </div>
                </div>
            ))
        }
    </div>
  )
}

export default ProductList