import React, { useContext, useRef, useState } from 'react'
import TextField from '../../elements/TextField';
import { useSelector } from 'react-redux';
import SelectField from '../../elements/SelectField';
import { useOutletContext } from 'react-router-dom';



const RequestProductDetails = (props) => {
  const [showPopup, setShowPopup] = useState(false);
  const [newProduct, setNewProduct] = useState({ Field_201_product_popup_product_type: { key: '', value: '' }, Field_202_product_popup_branch_type: { key: '', value: '' } })
  const productModalRef = useRef();
  const context = useOutletContext();
  const [newProductCounter, setNewProductCounter] = useState({counter:100});
  const uiFieldStore = useSelector(state => state.UIFieldStoreSlice);
  const onClickHandler = (evt) => {
    if (evt.target.name === 'Field_203_product_popup_add_button') {
      context.setProductDetails((prevState) => {
        setNewProductCounter((prev) => ({counter: (prev.counter+1)}))
        const tempId = 'TEMP_'+newProductCounter.counter;
        const retVal = {
          productsList: [
            ...prevState.productsList,
            {
              id: tempId,
              productStoreId: '',
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

  const removeProduct = (removeProductId) => {

    const result = context.productDetails.productsList.filter(item => item.id !== removeProductId)

    context.setProductDetails({ productsList: result })

  }


  const ProductPopup = (props) => {

    const masterData = useSelector(state => state.masterDataSlice)

    return (

      <div id="myModal" className="popup-modal" ref={productModalRef}>
        <div className="modal-content rounded">
          <div className='row'>
            <div className='col'>
              <div className='text-header-strong'>Add Product</div>
            </div>
            <div className='col'>
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
      <div className='m-2 section-standard' >
        <h6 className='tab-section-title'></h6>
        <div className=''>

        {context.stageEditable && uiFieldStore.uiButtons.Field_135_add_new_product_button && uiFieldStore.uiButtons.Field_135_add_new_product_button.isVisible &&
          <div className='w-100'>
            <button id='Field_135_add_new_product_button' name="addProduct" data-toggle="modal" data-target="#exampleModal"
              className='btn btn-primary' style={{ float: 'right', padding: '10px 20px ' }} onClick={() => setShowPopup(true)}>
              <strong>+</strong>
            </button></div>
        }

          <table className="table table-hover">
            <thead>
              <tr>
                <th scope="col">Id</th>
                <th scope="col">Store Id</th>
                <th scope="col">Account Number</th>
                <th scope="col">Product Name</th>
                <th scope="col">Product Branch</th>
                <th scope="col">Product Created</th>
                {context.stageEditable && uiFieldStore.uiButtons.Field_135_add_new_product_button && uiFieldStore.uiButtons.Field_135_add_new_product_button.isVisible &&
                <th scope="col">Action</th>
                }
              </tr>
            </thead>
            <tbody>
            { context.productDetails.productsList.length === 0 ? <tr><td colSpan="8"><h4 className='text-center mx-auto'>No Result Found</h4></td></tr>:""}
            {
               context.productDetails && context.productDetails.productsList.map(product => (
                  <tr key={product.id}>
                    <th>{product.id}</th>
                    <td>{product.productStoreId}</td>
                    <td>{product.accountId}</td>
                    <td>{product.productType.productTypeName}</td>
                    <td>{product.productBranch.branchTypeName}</td>
                    <td>{product.createdDate && product.createdDate.substring(0,10)}</td>
                    {context.stageEditable && uiFieldStore.uiButtons.Field_135_add_new_product_button && uiFieldStore.uiButtons.Field_135_add_new_product_button.isVisible &&
                    <td><button name="remove_product" className='btn btn-primary btn-sm' onClick={() => removeProduct(product.id)}>Remove</button></td>
                    }
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