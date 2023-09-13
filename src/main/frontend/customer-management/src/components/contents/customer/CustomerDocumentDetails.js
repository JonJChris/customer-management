import React from 'react'
import { useOutletContext } from 'react-router-dom';


const CustomerDocumentDetails = () => {
    const context = useOutletContext();
    return (
        <div className="tab-pane fade show active" id="home" role="tabpanel"  >
            <div className='m-2' >

                <div className=''>

                    <table className="table table-hover">
                        <thead>
                            <tr>
                                <th scope="col">Document Id</th>
                                <th scope="col">Document Type</th>
                                <th scope="col">Document Link Path</th>
                                <th scope="col">Document Created</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                context.documentDetails && context.documentDetails.documentsList.map(document => (
                                    <tr key={document.documentId}>
                                        <th scope="row">{document.documentId}</th>
                                        <td>{document.documentType.documentTypeName}</td>
                                        <td>{document.documentLinkPath}</td>
                                        <td>{document.createdDate}</td>
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

export default CustomerDocumentDetails