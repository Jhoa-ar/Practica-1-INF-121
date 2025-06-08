from medicamento import Medicamento
from farmacia import Farmacia
from archfarmacia import ArchFarmacia


m1 = Medicamento(1, "Golpex", "tos", 10.5, 50)
m2 = Medicamento(2, "Tabcin", "resfrio", 8.0, 40)
m3 = Medicamento(3, "Bronquix", "tos", 12.0, 20)


f1 = Farmacia("Farmacia Central", 1, "Av. Siempre Viva 123")
f1.agregarMedicamento(m1)
f1.agregarMedicamento(m2)

f2 = Farmacia("Farmacia Sur", 2, "Calle Falsa 456")
f2.agregarMedicamento(m3)


arch = ArchFarmacia("farmacias_arch")
arch.crearArchivo()
arch.adicionar(f1)
arch.adicionar(f2)

arch.mostrarMedicamentosTos(1)

arch.buscarFarmaciasConMedicamento("Golpex")
