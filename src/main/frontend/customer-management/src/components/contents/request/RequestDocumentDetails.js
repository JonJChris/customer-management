import React from 'react'


const RequestDocumentDetails = () => {
    const productsList = [
        { documentId: '6556568', documentNumber: "8985-856585-5", documentType: "Driving Licence", documentPurpose:"identity" },
        { documentId: '484552', documentNumber: "8658 0252 6552", documentType: "Passport", documentPurpose:"address"  },
        { documentId: '252525', documentNumber: "9865-98956-955", documentType: "House Deed", documentPurpose:"security"},
     
    ];

  return (
    <div className="tab-pane fade show active" id="home" role="tabpanel"  >
    <div className='m-2' >
    
    <div className=''>
                    <div className='w-100'>
                    <button id='136_add_new_document_button' name="addProduct" className='btn btn-primary' style={{float:'right', padding:'10px 20px '}}><strong>+</strong></button></div>
                    <table className="table table-hover">
                        <thead>
                            <tr>
                                <th scope="col">Document Id</th>
                                <th scope="col">Document Number</th>
                                <th scope="col">Document Type</th>
                                <th scope="col">Document Purpose</th>
                                <th scope="col">Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                productsList.map(document => (

                                    <tr key={document.documentId}>
                                        <th scope="row">{document.documentId}</th>
                                        <td>{document.documentNumber}</td>
                                        <td>{document.documentType}</td>
                                        <td>{document.documentPurpose}</td>
                                        <td><a href="#">Action</a></td>

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

export default RequestDocumentDetails