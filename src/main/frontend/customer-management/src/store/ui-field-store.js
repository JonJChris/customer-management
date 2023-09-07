import { createSlice } from '@reduxjs/toolkit'

const UIFieldStoreSlice = createSlice({
    name: "UIFieldStore",
    initialState: {
        uiFields: {
            Field_100_request_id: { isVisible: 'true', isEditable: 'false', isMandatory: 'false' },
            Field_101_reqeust_created: { isVisible: 'true', isEditable: 'false', isMandatory: 'false' },
            Field_102_reuest_type: { isVisible: 'true', isEditable: 'false', isMandatory: 'false' },
            Field_103_request_status: { isVisible: 'true', isEditable: 'false', isMandatory: 'false' },
            Field_104_customer_id: { isVisible: 'true', isEditable: 'false', isMandatory: 'false' },
            Field_105_customer_title: { isVisible: 'true', isEditable: 'false', isMandatory: 'false' },
            Field_106_customer_first_name: { isVisible: 'true', isEditable: 'false', isMandatory: 'false' },
            Field_107_customer_last_name: { isVisible: 'true', isEditable: 'false', isMandatory: 'false' },
            Field_108_customer_display_name: { isVisible: 'true', isEditable: 'false', isMandatory: 'false' },
            Field_109_customer_nationality: { isVisible: 'true', isEditable: 'false', isMandatory: 'false' },
            Field_110_customer_date_of_birth: { isVisible: 'true', isEditable: 'false', isMandatory: 'false' },
            Field_112_customer_marital_status: { isVisible: 'true', isEditable: 'false', isMandatory: 'false' },
            Field_113_customer_type: { isVisible: 'true', isEditable: 'false', isMandatory: 'false' },
            Field_114_reg_address_line1: { isVisible: 'true', isEditable: 'false', isMandatory: 'false' },
            Field_115_reg_address_line2: { isVisible: 'true', isEditable: 'false', isMandatory: 'false' },
            Field_116_reg_address_city: { isVisible: 'true', isEditable: 'false', isMandatory: 'false' },
            Field_117_reg_address_state: { isVisible: 'true', isEditable: 'false', isMandatory: 'false' },
            Field_118_reg_address_country: { isVisible: 'true', isEditable: 'false', isMandatory: 'false' },
            Field_119_reg_address_postal_code: { isVisible: 'true', isEditable: 'false', isMandatory: 'false' },
            Field_120_com_address_line1: { isVisible: 'true', isEditable: 'false', isMandatory: 'false' },
            Field_121_com_address_line2: { isVisible: 'true', isEditable: 'false', isMandatory: 'false' },
            Field_122_com_address_city: { isVisible: 'true', isEditable: 'false', isMandatory: 'false' },
            Field_123_com_address_state: { isVisible: 'true', isEditable: 'false', isMandatory: 'false' },
            Field_124_com_address_country: { isVisible: 'true', isEditable: 'false', isMandatory: 'false' },
            Field_125_com_address_postal_code: { isVisible: 'true', isEditable: 'false', isMandatory: 'false' },
            Field_126_educational_qualification: { isVisible: 'true', isEditable: 'false', isMandatory: 'false' },
            Field_127_occupation_type: { isVisible: 'true', isEditable: 'false', isMandatory: 'false' },
            Field_128_organisation_name: { isVisible: 'true', isEditable: 'false', isMandatory: 'false' },
            Field_129_designation: { isVisible: 'true', isEditable: 'false', isMandatory: 'false' },
            Field_130_yearly_income: { isVisible: 'true', isEditable: 'false', isMandatory: 'false' },
            Field_131_educational_level: { isVisible: 'true', isEditable: 'false', isMandatory: 'false' },
            Field_132_nominee_realtionship_type: { isVisible: 'true', isEditable: 'false', isMandatory: 'false' },
            Field_133_nominee_first_name: { isVisible: 'true', isEditable: 'false', isMandatory: 'false' },
            Field_134_nominee_last_name: { isVisible: 'true', isEditable: 'false', isMandatory: 'false' },
            Field_135_add_new_product_button: { isVisible: 'true', isEditable: 'false', isMandatory: 'false' },
            Field_136_add_new_document_button: { isVisible: 'true', isEditable: 'false', isMandatory: 'false' },
            Field_137_basic_details_tab: { isVisible: 'true', isEditable: 'false', isMandatory: 'false' },
            Field_138_address_details_tab: { isVisible: 'true', isEditable: 'false', isMandatory: 'false' },
            Field_139_additional_details_tab: { isVisible: 'true', isEditable: 'false', isMandatory: 'false' },
            Field_140_product_details_tab: { isVisible: 'true', isEditable: 'false', isMandatory: 'false' },
            Field_141_document_details_tab: { isVisible: 'true', isEditable: 'false', isMandatory: 'false' },
            Field_142_home_ownership_type: { isVisible: 'true', isEditable: 'false', isMandatory: 'false' },
            Field_143_nominee_date_of_birth: { isVisible: 'true', isEditable: 'false', isMandatory: 'false' },
        }
    },
    reducers: {
        updateUIFields: (state, action) => {
            const newState = {}
            if (action.payload) {
                action.payload.map(item => newState[item.fieldName] = { isVisible: item.isVisible, isEditable: item.isEditable, isMandatory: item.isMandatory })
            }
            state.uiFields = {
                ...newState
            }

        }
    }

});

export const actions = UIFieldStoreSlice.actions;
export default UIFieldStoreSlice;