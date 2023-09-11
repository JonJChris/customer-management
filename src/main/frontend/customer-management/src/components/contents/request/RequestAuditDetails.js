import React from 'react'


const RequestAuditDetails = () => {

    const auditList = [
        { auditId: '6556568', oldValue: "8985-856585-5", newValue: "56656622-96", changedBy:"User-1" , changedOn:"01-02-2023"},
        { auditId: '8585855', oldValue: "54645-4545-5", newValue: "Driving235652-56856", changedBy:"User-2" , changedOn:"21-02-2023"},
        { auditId: '9895856', oldValue: "4545-45454-5", newValue: "663232625-55", changedBy:"User-1" , changedOn:"31-03-2023"},
        
     
    ];
  return (
   
    <div className="tab-pane fade show active" id="home" role="tabpanel"  >
    <div className='m-2' >
    
    <div className=''>
                    <div className='w-100'><button name="addProduct" className='btn btn-primary' style={{float:'right', padding:'10px 20px '}}><strong>+</strong></button></div>
                    <table className="table table-hover">
                        <thead>
                            <tr>
                                <th scope="col">Audit Id</th>
                                <th scope="col">Old Value</th>
                                <th scope="col">New Value</th>
                                <th scope="col">Chagned By</th>
                                <th scope="col">Changed On</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                auditList.map(audit => (

                                    <tr key={audit.auditId}>
                                        <th scope="row">{audit.auditId}</th>
                                        <td>{audit.oldValue}</td>
                                        <td>{audit.newValue}</td>
                                        <td>{audit.changedBy}</td>
                                        <td>{audit.changedOn}</td>

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

export default RequestAuditDetails