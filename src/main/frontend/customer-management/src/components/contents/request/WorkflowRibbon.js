import React from 'react'

const WorkflowRibbon = (props) => {
  return (
    <div className=' wf-container border border-rounded'  >
      
       {props.stages && props.stages.stagesList.map(
        item => (
          <div key={item.id} className={`border border-rounded arrow-right wf-stage ${item.statusTypeModel && 'wf-stage-'+item.statusTypeModel.statusTypeName.toLowerCase() }`}>{item.stageTypeModel && item.stageTypeModel.stageName}</div>
          
        ))}
    </div>
  )
}

export default WorkflowRibbon