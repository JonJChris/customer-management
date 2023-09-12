import React, { useContext, useRef, useState } from 'react'
import TextField from '../../elements/TextField';
import { useSelector } from 'react-redux';
import SelectField from '../../elements/SelectField';
import { useOutletContext } from 'react-router-dom';



const RequestProductDetails = (props) => {
  const productsList = [
    { accountId: 10001, accountNumber: '1256858', productName: "Fixed Deposit", productBranch: "Singapore" },
    { accountId: 10002, accountNumber: '536552', productName: "Savings Account", productBranch: "India" },
    { accountId: 10004, accountNumber: '985475', productName: "Current Account", productBranch: "Thailand" },
    { accountId: 10005, accountNumber: '00656855', productName: "Credit Card", productBranch: "Hongkong" },
    { accountId: 10006, accountNumber: '65854585', productName: "Personal Load", productBranch: "India" },
    { accountId: 10007, accountNumber: '65854585', productName: "Vechicle Load", productBranch: "Malaysia" },
    { accountId: 10008, accountNumber: '65854585', productName: "House Mortgage", productBranch: "Singapore" },
  ];
  const [showPopup, setShowPopup] = useState(false);
  const [newProduct, setNewProduct] = useState({ Field_201_product_popup_product_type: { key: '', value: '' }, Field_202_product_popup_branch_type: { key: '', value: '' } })
  const productModalRef = useRef();
  const context = useOutletContext();
  const onClickHandler = (evt) => {
    if (evt.target.name === 'Field_203_product_popup_add_button') {
      context.setProductDetails((prevState) => {
        const retVal = {
          productsList: [
            ...prevState.productsList,
            {
              productId: 0,
              accountId: 'NEW',
              createdDate: '',
              productType: {
                productTypeId: newProduct.Field_201_product_popup_product_type.key,
                productTypeName: newProduct.Field_201_product_popup_product_type.value,
              },
              productBranch: {
                branchTypeId: newProduct.Field_202_product_popup_branch_type.key,
                branchTypeName: newProduct.Field_202_product_popup_branch_type.value,
              }
            }
          ]
        }

        setNewProduct({ Field_201_product_popup_product_type: { key: '', value: '' }, Field_202_product_popup_branch_type: { key: '', value: '' } });
        return retVal;
      });
      setShowPopup(false);
    } else if (evt.target.name === 'Field_204_product_popup_cancel_button') {
      setNewProduct({ Field_201_product_popup_product_type: { key: '', value: '' }, Field_202_product_popup_branch_type: { key: '', value: '' } });
      setShowPopup(false);
    }
   
  }
  const onChangeHandler = (evt) => {
    console.log(evt.target.name)
    setNewProduct((prevState) => {
      return {
        ...prevState,
        [evt.target.name]: {
          key: evt.target.value,
          value: evt.target.options[evt.target.selectedIndex].text
        }
      }
    })
  }

const removeProduct = (removeProductId)  => {
  console.log("removeProductId: "+removeProductId)
  const result = context.productDetails.productsList.filter(item => item.productId !== removeProductId)
  console.log("TTT "+ JSON.stringify(result));
  context.setProductDetails({productsList: result})
 
}
  

  const ProductPopup = (props) => {

    const masterData = useSelector(state => state.masterDataSlice)
    console.log("AAA " + JSON.stringify(masterData.productModelList));
    return (

      <div id="myModal" className="popup-modal" ref={productModalRef}>
        <div className="modal-content rounded">
          <div className='row'>
            <div className='col'>
              <div className='text-header-strong'>Add Product</div>
            </div>
            <div className='col'>
              <div className='text-end'><button className='text-end btn btn-primary btn-sm btn-block' onClick={() => console.log('modal close')}>X</button></div>
            </div>
            <hr className='mt-2' />
          </div>

          <div className='row'>
            <div className='col-6 mx-auto'>
              <SelectField fieldId="Field_201_product_popup_product_type" fieldName="Product Type"
                fieldValue={props.newProduct.Field_201_product_popup_product_type}
                fieldOptions={masterData.productModelList}
                fieldOnChange={props.changeHandler} isMandatory={false} isVisible={true} isEditable={true} />
            </div>
          </div>
          <div className='row'>
            <div className='col-6 mx-auto'>
              <SelectField fieldId="Field_202_product_popup_branch_type" fieldName="Product Branch"
                fieldValue={props.newProduct.Field_202_product_popup_branch_type}
                fieldOptions={masterData.branchModelList}
                fieldOnChange={props.changeHandler} isMandatory={false} isVisible={true} isEditable={true} />
            </div>
          </div>
          <div className='row mt-5'>
            <div className='col-2 mx-auto'></div>
            <div className='col-2 mx-auto'>
              <button name="Field_203_product_popup_add_button" className='btn btn-primary px-5' onClick={props.clickHandler} disabled={
                !(props.newProduct.Field_201_product_popup_product_type 
                  && props.newProduct.Field_202_product_popup_branch_type 
                  && props.newProduct.Field_201_product_popup_product_type.key !== ''
                  && props.newProduct.Field_202_product_popup_branch_type.key !== ''
                  )
              } >Add</button>
            </div>
            <div className='col-2 mx-auto'>
              <button name="Field_204_product_popup_cancel_button" className='btn btn-primary px-5' onClick={props.clickHandler}>Cancel</button>
            </div>
            <div className='col-2 mx-auto'></div>
          </div>
        </div>
      </div>
    )
  }
  return (
    <div className="tab-pane fade show active" id="home" role="tabpanel"  >
      <div className='m-2' >
        <h6 className='tab-section-title'></h6>
        <div className=''>
          <div className='w-100'>

            <button id='135_add_new_product_button' name="addProduct" data-toggle="modal" data-target="#exampleModal"
              className='btn btn-primary' style={{ float: 'right', padding: '10px 20px ' }} onClick={() => setShowPopup(true)}>
              <strong>+</strong>
            </button></div>
          <table className="table table-hover">
            <thead>
              <tr>
                <th scope="col">Product Id</th>
                <th scope="col">Account Number</th>
                <th scope="col">Product Name</th>
                <th scope="col">Product Branch</th>
                <th scope="col">Product Created</th>
                <th scope="col">Action</th>
              </tr>
            </thead>
            <tbody>
              {
                context.productDetails && context.productDetails.productsList.map(product => (
                  <tr key={product.productId}>
                    <td>{product.productId}</td>
                    <td>{product.accountId}</td>
                    <td>{product.productType.productTypeName}</td>
                    <td>{product.productBranch.branchTypeName}</td>
                    <td>{product.createdDate}</td>
                    <td><button name="remove_product" className='btn btn-primary btn-sm' onClick={() => removeProduct(product.productId)}>Remove</button></td>
                  </tr>
                ))
              }


            </tbody>
          </table>


        </div>

      </div>

      {showPopup && <ProductPopup newProduct={newProduct} clickHandler={onClickHandler} changeHandler={onChangeHandler} />}
    </div>
  )
}

export default RequestProductDetails