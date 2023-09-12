import React, { useEffect, useState } from 'react'
import { useOutletContext } from 'react-router-dom';
import TextField from '../../elements/TextField';
import { useSelector } from 'react-redux';
import SelectField from '../../elements/SelectField';


const RequestDocumentDetails = () => {
    const context = useOutletContext();


    const [showPopup, setShowPopup] = useState(false);
    const [newDocument, setNewDocument] = useState({ Field_205_document_popup_document_type: { key: '', value: '' }, Field_206_document_popup_document_path: '' })

    const onClickHandler = (evt) => {
        if (evt.target.name === 'Field_207_document_popup_add_button') {
            context.setDocumentDetails((prevState) => {
                const retVal = {
                    documentsList: [
                        ...prevState.documentsList,
                        {
                            documentId: 0,
                            createdDate: '',
                            documentType: {
                                documentTypeId: newDocument.Field_205_document_popup_document_type.key,
                                documentTypeName: newDocument.Field_205_document_popup_document_type.value,
                            },
                            documentLinkPath: newDocument.Field_206_document_popup_document_path
                        }
                    ]
                }

                setNewDocument({ Field_205_document_popup_document_type: { key: '', value: '' }, Field_205_document_popup_document_type: '' });
                return retVal;
            });
            setShowPopup(false);
        } else if (evt.target.name === 'Field_208_document_popup_cancel_button') {
            setNewDocument({ Field_205_document_popup_document_type: { key: '', value: '' }, Field_205_document_popup_document_type: '' });
            setShowPopup(false);
        }

    }
    const onChangeHandler = (evt) => {
        console.log(evt.target.name)
        if (evt.target.type === 'select-one') {
            setNewDocument((prevState) => {
                return {
                    ...prevState,
                    [evt.target.name]: {
                        key: evt.target.value,
                        value: evt.target.options[evt.target.selectedIndex].text
                    }
                }
            })
        }else{
            setNewDocument((prevState) => {
                return {
                    ...prevState,
                    [evt.target.name]: evt.target.value,
                }
            }) 
        }

    }

    const removeDocument = (removeDocumentId)  => {
        console.log("removeProductId: "+removeDocumentId)
        const result = context.documentDetails.documentsList.filter(item => item.documentId !== removeDocumentId)
        console.log("TTT "+ JSON.stringify(result));
        context.setDocumentDetails({documentsList: result})
       
      }


    const DocumentPopup = (props) => {

        const masterData = useSelector(state => state.masterDataSlice)
        
        
        useEffect(() => {},[])
        return (

            <div id="myModal" className="popup-modal" >
                <div className="modal-content rounded">
                    <div className='row'>
                        <div className='col'>
                            <div className='text-header-strong'>Add Document</div>
                        </div>
                        <hr className='mt-2' />
                    </div>

                    <div className='row'>
                        <div className='col-6 mx-auto'>
                            <SelectField fieldId="Field_205_document_popup_document_type" fieldName="Document Type"
                                fieldValue={props.newDocument.Field_205_document_popup_document_type}
                                fieldOptions={masterData.documentTypeModelList}
                                fieldOnChange={props.changeHandler} isMandatory={false} isVisible={true} isEditable={true} />
                        </div>
                    </div>
                    <div className='row'>
                        <div className='col-6 mx-auto'>
                            <TextField fieldId="Field_206_document_popup_document_path" fieldName="Document Link"
                                fieldValue={props.newDocument.Field_206_document_popup_document_path}
                                fieldOnChange={props.changeHandler} isMandatory={false} isVisible={true} isEditable={true}  />
                        </div>
                    </div>
                    <div className='row mt-5'>
                        <div className='col-2 mx-auto'></div>
                        <div className='col-2 mx-auto'>
                            <button name="Field_207_document_popup_add_button" className='btn btn-primary px-5' onClick={props.clickHandler} disabled={

                                !(props.newDocument.Field_205_document_popup_document_type
                                    && props.newDocument.Field_206_document_popup_document_path
                                    && props.newDocument.Field_205_document_popup_document_type.key !== ''
                                    && props.newDocument.Field_206_document_popup_document_path !== ''
                                )
                            } >Add</button>
                        </div>
                        <div className='col-2 mx-auto'>
                            <button name="Field_208_document_popup_cancel_button" className='btn btn-primary px-5' onClick={props.clickHandler}>Cancel</button>
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

                <div className=''>
                    <div className='w-100'>
                        <button id='136_add_new_document_button' name="addDocument" className='btn btn-primary'
                            style={{ float: 'right', padding: '10px 20px ' }} onClick={() => setShowPopup(true)}><strong>+</strong></button></div>
                    <table className="table table-hover">
                        <thead>
                            <tr>
                                <th scope="col">Document Id</th>
                                <th scope="col">Document Type</th>
                                <th scope="col">Document Link Path</th>
                                <th scope="col">Document Created</th>
                                <th scope="col">Action</th>
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
                                        <td><button name="remove_document" className='btn btn-primary btn-sm'  onClick={() => removeDocument(document.documentId)}>Remove</button></td>

                                    </tr>
                                ))
                            }


                        </tbody>
                    </table>


                </div>

                {showPopup && <DocumentPopup newDocument={newDocument} clickHandler={onClickHandler} changeHandler={onChangeHandler} />}
            </div>
        </div>
    )
}

export default RequestDocumentDetails