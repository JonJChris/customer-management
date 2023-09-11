import React from 'react'

const MasterDataLoader = () => {

 const loadMasterData = async () => {
    
    const resp = await fetch("htto://localhost:8080/masterData/requestType");
    const reqTypes = await resp.json();
    
 }


  return (
    <div>{loadMasterData()}</div>
  )
}

export default MasterDataLoader