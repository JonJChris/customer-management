import React from 'react'
import { useSelector } from 'react-redux'

const RequestButtons = (props) => {
  const uiFieldStore = useSelector(state => state.UIFieldStoreSlice);
  
  return (
    <div className='border border-rounded mt-3 p-3'>
      <div className='row'>
        {props.stageEditable && uiFieldStore.uiButtons.Field_146_request_rework && uiFieldStore.uiButtons.Field_146_request_rework.isVisible &&
          <div className='col-1'><button className='btn btn-primary'
            name="Field_146_request_rework" onClick={props.fieldOnSubmit}
            disabled={ uiFieldStore.uiButtons.Field_146_request_rework && !uiFieldStore.uiButtons.Field_146_request_rework.isEditable}
          >Rework</button></div>
        }
        <div className='col-9'></div>
        {props.stageEditable && uiFieldStore.uiButtons.Field_209_request_save && uiFieldStore.uiButtons.Field_209_request_save.isVisible &&
          <div className='col-1'><button className='btn btn-primary'
            name="Field_209_request_save" onClick={props.fieldOnSubmit}
            disabled={uiFieldStore.uiButtons.Field_209_request_save && !uiFieldStore.uiButtons.Field_209_request_save.isEditable}
          >Save</button></div>
        }
        {props.stageEditable && uiFieldStore.uiButtons.Field_145_request_submit && uiFieldStore.uiButtons.Field_145_request_submit.isVisible &&
          <div className='col-1'><button className='btn btn-primary'
            name="Field_145_request_submit" onClick={props.fieldOnSubmit}
            disabled={uiFieldStore.uiButtons.Field_145_request_submit && !uiFieldStore.uiButtons.Field_145_request_submit.isEditable}
          >Submit</button></div>
        }
      </div>
    </div>
  )
}

export default RequestButtons
