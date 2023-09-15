import React, { useEffect } from 'react'
import { Outlet } from 'react-router-dom'
import NavBarCustom from '../contents/common/NavBarCustom'
import { useDispatch, useSelector } from 'react-redux';
import { actions } from './../../store/master-data'
import { putRequestAndThenCallBack, getRequestAndThenCallBack } from './../utility/api-util'
const AppLayout = () => {
    const dispatch = useDispatch();
    const masterData = useSelector(state => state.masterDataSlice);
    const updateMasterDataInStore = (masterData) => {
        dispatch(actions.refreshMasterData(masterData));
    }

    useEffect(() => {
        if (!masterData.masterDataExists) {
            getRequestAndThenCallBack('http://localhost:8080/api/masterData/fetchAll', updateMasterDataInStore);
        }
    });

    return (
        <div>
            <NavBarCustom />
            <Outlet />
        </div>
    )
}

export default AppLayout