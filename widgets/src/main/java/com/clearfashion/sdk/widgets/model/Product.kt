package com.clearfashion.sdk.widgets.model

internal interface Product {
    val productName: String
    val brandName: String
    val brandCode: String
    val readableRecyclability: String
    val shouldDisplayRecyclability: Boolean
    val productCategory: String
    val emittingMicroFiber: Boolean
    val recycledPercentage: Int
    val syntheticPercentage: Int
    val productionStepOrigins: String // Todo: change struct
    val dangerousSubstances: Array<String>
    val concerningSubstances: Array<String>
    val hasMaterialImpacts: Boolean
    val importedAt: String
}