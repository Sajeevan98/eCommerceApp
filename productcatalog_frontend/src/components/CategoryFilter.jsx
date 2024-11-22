import React from 'react'

const CategoryFilter = ({category, onSelect}) => {

    
  return (
    <select id="categorySelect" className='form-control' onChange={(e) => onSelect(e.target.value)}>
        <option value="">All Categories</option>
        {
            category.map(ca =>(
                <option key={ca.id} value={ca.id}>{ca.name }</option>
            ))
        }
    </select>
  )
}

export default CategoryFilter