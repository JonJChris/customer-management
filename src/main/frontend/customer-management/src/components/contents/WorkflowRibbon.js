import React from 'react'

const WorkflowRibbon = (props) => {
  return (
    <div className=' wf-container'  >
      <hr />
      
       {props.items.map(
        item => (
          <div key={item.stageId} className={`border border-rounded arrow-right wf-stage ${item.stageStatus && 'wf-stage-'+item.stageStatus.toLowerCase() }`}>{item.stageName}</div>
          
        ))}
    </div>
  )
}

export default WorkflowRibbon