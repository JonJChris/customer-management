import React from 'react'
import { useOutletContext } from 'react-router-dom';


const CustomerProductDetails = () => {
    const context = useOutletContext();
    return (
        <div className="tab-pane fade show active" id="home" role="tabpanel"  >
            <div className='m-2 section-standard' >
                <h6 className='tab-section-title'></h6>
                <div className=''>

                    <table className="table table-hover">
                        <thead>
                            <tr>
                                <th scope="col">Product Id</th>
                                <th scope="col">Account Number</th>
                                <th scope="col">Product Name</th>
                                <th scope="col">Product Branch</th>
                                <th scope="col">Product Created</th>
                            </tr>
                        </thead>
                        <tbody>
                        { context.productDetails.productsList.length === 0 ? <tr><td colSpan="8"><h4 className='text-center mx-auto'>No Result Found</h4></td></tr>:""}
                            {
                                context.productDetails && context.productDetails.productsList.map(product => (

                                    <tr key={product.productId}>
                                        <th>{product.productId}</th>
                                        <td>{product.accountId}</td>
                                        <td>{product.productType.productTypeName}</td>
                                        <td>{product.productBranch.branchTypeName}</td>
                                        <td>{product.createdDate && product.createdDate.substring(0, 10)}</td>
                                    </tr>
                                ))
                            }
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    )
}

export default CustomerProductDetails