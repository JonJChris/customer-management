import React from 'react'

const CustomerSearchResult = (props) => {
    console.log("OBJ"+props.searchResult)
    console.log("ELN "+props.searchResult.length)
    return (
        <div className='mt-3 border border-rounded p-3'>
            <table className="table">
                <thead>
                    <tr>
                        <th scope="col">Customer ID</th>
                        <th scope="col">First Name</th>
                        <th scope="col">Last Name</th>
                        <th scope="col">Nationality</th>
                    </tr>
                </thead>
                <tbody>
                    
                    {props.searchResult.length === 0 ? <tr><td colSpan="4"><h4 className='text-center mx-auto'>No Result Found</h4></td></tr>:""}
                    {props.searchResult && props.searchResult.map(item => (
                        <tr>
                            <th scope="row">{item.customerId}</th>
                            <td>{item.firstName}</td>
                            <td>{item.lastName}</td>
                            <td>{item.nationality}</td>
                        </tr>
                    ))}
            </tbody>
        </table>
        </div >

    )
}

export default CustomerSearchResult