package org.psota.invoices.exception

import java.util.*

class NotFoundException : IllegalArgumentException {
    constructor(message: String?) : super(message)

    constructor(classType: Class<*>, id: UUID) : super("${classType.simpleName} (id= $id) does not exist.")
}