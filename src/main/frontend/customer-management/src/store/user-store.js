import { createSlice } from '@reduxjs/toolkit'

const UserStoreSlice = createSlice({
    name: "UserStore",
    initialState: {
        userDetails: {
            // userId: 25000,
            // username: 'maggieparker',
            // userFirstName: 'Maggie',
            // userLastName: 'Parker',
            // userRoles: [
            //     {
            //         "roleTypeId": 28004,
            //         "roleTypeName": "FRONT_OFFICE"
            //     }
            // ]

            userId: 0,
            username: '',
            userFirstName: '',
            userLastName: '',
            userRoles:[]
        }
    },
    reducers: {
        setUserDetail: (state, action) => {
            state.userDetails.userId = action.payload.userModel.userId;
            state.userDetails.username = action.payload.userModel.username;
            state.userDetails.userFirstName = action.payload.userModel.userFirstName;
            state.userDetails.userLastName = action.payload.userModel.userLastName;
            state.userDetails.userRoles = action.payload.userModel.userRoles;

        },
        unsetUserDetail: (state, action) => {
            state.userDetails= {
                userId: 0,
                username: '',
                userFirstName: '',
                userLastName: '',
                userRoles: []
            }
        }
    }
}
);

export const actions = UserStoreSlice.actions;
export default UserStoreSlice;

