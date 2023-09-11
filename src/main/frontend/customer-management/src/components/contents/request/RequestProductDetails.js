import React, {useRef} from 'react'



const RequestProductDetails = () => {
  const productsList = [
    { accountId: 10001, accountNumber: '1256858', productName: "Fixed Deposit", productBranch: "Singapore" },
    { accountId: 10002, accountNumber: '536552', productName: "Savings Account", productBranch: "India" },
    { accountId: 10004, accountNumber: '985475', productName: "Current Account", productBranch: "Thailand" },
    { accountId: 10005, accountNumber: '00656855', productName: "Credit Card", productBranch: "Hongkong" },
    { accountId: 10006, accountNumber: '65854585', productName: "Personal Load", productBranch: "India" },
    { accountId: 10007, accountNumber: '65854585', productName: "Vechicle Load", productBranch: "Malaysia" },
    { accountId: 10008, accountNumber: '65854585', productName: "House Mortgage", productBranch: "Singapore" },
  ];

  const productModalRef =useRef();

  return (
    <div className="tab-pane fade show active" id="home" role="tabpanel"  >
      <div className='m-2' >
        <h6 className='tab-section-title'></h6>
        <div className=''>
          <div className='w-100'>

            <button id='135_add_new_product_button' name="addProduct" data-toggle="modal" data-target="#exampleModal"
              className='btn btn-primary' style={{ float: 'right', padding: '10px 20px ' }} onClick={() => console.log(productModalRef.current.style.display = 'block')}>
              <strong>+</strong>
            </button></div>
          <table className="table table-hover">
            <thead>
              <tr>
                <th scope="col">Account Id</th>
                <th scope="col">Account Number</th>
                <th scope="col">Product Name</th>
                <th scope="col">Prodcut Branch</th>
                <th scope="col">Action</th>
              </tr>
            </thead>
            <tbody>
              {
                productsList.map(product => (

                  <tr key={product.accountId}>
                    <th scope="row">{product.accountId}</th>
                    <th scope="row">{product.accountNumber}</th>
                    <td>{product.productName}</td>
                    <td>{product.productBranch}</td>
                    <td><a href="#">Action</a></td>

                  </tr>
                ))
              }


            </tbody>
          </table>


        </div>

      </div>


      <div id="myModal" className="product-modal prod" ref={productModalRef}>


        <div className="modal-content">
          <span className="close">&times;</span>
          <p>Some text in the Modal..</p>
        </div>

      </div>
    </div>
  )
}

export default RequestProductDetails