import React from 'react'
import { NavLink } from 'react-router-dom'

const RequestSearchResult = (props) => {
    return (
        <div className='mt-3 border border-rounded p-3'>
            <table className="table">
                <thead>
                    <tr>
                        <th scope="col">Request ID</th>
                        <th scope="col">Customer First Name</th>
                        <th scope="col">Customer Last Name</th>
                        <th scope="col">Request Type</th>
                    </tr>
                </thead>
                <tbody>
                    
                    {props.searchResult.length === 0 ? <tr><td colSpan="4"><h4 className='text-center mx-auto'>No Result Found</h4></td></tr>:""}
                    {props.searchResult && props.searchResult.map(item => (
                        <tr key={item.requestId}>
                            <th scope="row"><NavLink to={`/request/${item.requestId}/basic`}>{item.requestId}</NavLink></th>
                            <td>{item.customerFirstName}</td>
                            <td>{item.customerLastName}</td>
                            <td>{item.requestType}</td>
                        </tr>
                    ))}
            </tbody>
        </table>
        </div >

    )
}

export default RequestSearchResult